CREATE EXTENSION postgis;

-- Se seleccionan unicamente zonas censales correspondientes a la comuna de puente alto

SELECT *
FROM zonas_censales_gs
WHERE nom_comuna = 'PUENTE ALTO';

-- georref minimarkets

ALTER TABLE minimarkets_gs ADD COLUMN geom geometry(Point, 4326);
UPDATE minimarkets_gs SET geom = ST_MakePoint(longitud, latitud);

-- Se une columna de comuna a tabla de minimarkets

SELECT mini.*, zonas.nom_comuna
FROM minimarkets_gs AS mini
JOIN zonas_censales_gs AS zonas
ON ST_intersects(zonas.geom, ST_Transform(mini.geom, 32719));

-- Tabla de minimarkets por zona

SELECT zonas.geocodigo, zonas.geom, COUNT(mini.geom) as n_minimarkets
FROM zonas_censales_gs AS zonas
LEFT JOIN minimarkets_gs AS mini
ON ST_Contains(zonas.geom, ST_Transform(mini.geom, 32719))
GROUP BY zonas.geocodigo, zonas.geom;

-- Capa espacial de comunas con minimarkets

CREATE TABLE comunas_minimarkets AS
(SELECT zonas.nom_comuna, ST_union(zonas.geom), count(mini.geom) as  n_minimarkets
FROM zonas_censales_gs as zonas
LEFT JOIN minimarkets_gs as mini
ON ST_Contains(zonas.geom, ST_Transform(mini.geom, 32719))
GROUP BY nom_comuna);


-- Consulta sistema de coordenadas
SELECT ST_SRID(geom)
FROM zonas_censales_gs


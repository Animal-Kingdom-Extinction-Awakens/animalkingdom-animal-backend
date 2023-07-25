SELECT
    a.id,
    a.name,
    a.description,
    r.id AS idRarity,
    r.name AS nameRarity,
    s.id AS idSpecie,
    s.name AS nameSpecie,
    s.description AS descriptionSpecie
FROM animal a
         INNER JOIN rarity r on r.id = a.id_rarity
         INNER JOIN specie s on s.id = a.id_specie
WHERE a.id = :id;
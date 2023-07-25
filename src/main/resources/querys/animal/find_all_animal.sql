SELECT
    a.id,
    a.name,
    r.id AS idRarity,
    r.name AS nameRarity,
    s.name AS specie
FROM animal a
         INNER JOIN rarity r on r.id = a.id_rarity
         INNER JOIN specie s on s.id = a.id_specie;
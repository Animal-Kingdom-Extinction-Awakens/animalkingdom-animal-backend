UPDATE animal
SET name        = :name,
    description = :description,
    id_specie   = :idSpecie,
    id_rarity   = :idRarity,
    key         = :key
WHERE id = :id
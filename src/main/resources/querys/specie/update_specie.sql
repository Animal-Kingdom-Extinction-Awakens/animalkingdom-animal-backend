UPDATE specie
SET name        = :name,
    description = :description
WHERE id = :id;
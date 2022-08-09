package com.g2g.g2g.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.g2g.g2g.model.item;

@Repository
public interface ItemRepository extends JpaRepository<item, Integer> {

    // Query return data in ascending order
    @Query(value = "SELECT * FROM item i WHERE name LIKE %:nameLike% OR description LIKE %:descriptionLike% ORDER BY :order LIMIT :limit  Offset :Offset", nativeQuery = true)
    public List<item> getItemWithQuaryFilterWithNameAndDescription(@Param("limit") int limit,
            @Param("Offset") int Offset, @Param("nameLike") String nameLike,
            @Param("descriptionLike") String descriptionLike, @Param("order") String orderBy);

    @Query(value = "SELECT * FROM item i WHERE name LIKE %:nameLike% ORDER BY :order LIMIT :limit  Offset :Offset", nativeQuery = true)
    public List<item> getItemWithQuaryFilterWithName(@Param("limit") int limit, @Param("Offset") int Offset,
            @Param("nameLike") String nameLike,
            @Param("order") String orderBy);

    @Query(value = "SELECT * FROM item i WHERE description LIKE %:descriptionLike% ORDER BY :order LIMIT :limit  Offset :Offset", nativeQuery = true)
    public List<item> getItemWithQuaryFilterWithDescription(@Param("limit") int limit, @Param("Offset") int Offset,
            @Param("descriptionLike") String descriptionLike, @Param("order") String orderBy);

    @Query(value = "SELECT * FROM item i  ORDER BY :order LIMIT :limit  Offset :Offset", nativeQuery = true)
    public List<item> getItemWithQuary(@Param("limit") int limit, @Param("Offset") int Offset,
            @Param("order") String orderBy);

    // Query return data in decending order

    @Query(value = "SELECT * FROM item i WHERE name LIKE %:nameLike% OR description LIKE %:descriptionLike% ORDER BY :order DESC LIMIT :limit  Offset :Offset", nativeQuery = true)
    public List<item> getItemWithQuaryFilterWithNameAndDescriptionDESC(@Param("limit") int limit,
            @Param("Offset") int Offset, @Param("nameLike") String nameLike,
            @Param("descriptionLike") String descriptionLike, @Param("order") String orderBy);

    @Query(value = "SELECT * FROM item i WHERE name LIKE %:nameLike% ORDER BY :order DESC LIMIT :limit Offset :Offset", nativeQuery = true)
    public List<item> getItemWithQuaryFilterWithNameDESC(@Param("limit") int limit, @Param("Offset") int Offset,
            @Param("nameLike") String nameLike,
            @Param("order") String orderBy);

    @Query(value = "SELECT * FROM item i WHERE description LIKE %:descriptionLike% ORDER BY :order DESC LIMIT :limit  Offset :Offset", nativeQuery = true)
    public List<item> getItemWithQuaryFilterWithDescriptionDESC(@Param("limit") int limit, @Param("Offset") int Offset,
            @Param("descriptionLike") String descriptionLike, @Param("order") String orderBy);

    @Query(value = "SELECT * FROM item i  ORDER BY :order DESC LIMIT :limit  Offset :Offset", nativeQuery = true)
    public List<item> getItemWithQuaryDESC(@Param("limit") int limit, @Param("Offset") int Offset,
            @Param("order") String orderBy);

}

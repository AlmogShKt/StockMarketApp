package com.plcoding.stockmarketapp.data.local

import androidx.room.Dao
import androidx.room.DeleteColumn.Entries
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.plcoding.stockmarketapp.domain.model.CompanyListing


@Dao
interface StockDao {

    // If there is a problem with the indexing - replace it with other one
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCompanyListing(
        companyListingEntries: List<CompanyListingEntity>
    )

    @Query("DELETE FROM CompanyListingEntity")
    suspend fun clearCompanyListing()


    @Query(
        """
        SELECT * 
        FROM CompanyListingEntity
        WHERE LOWER(name) LIKE '%' || LOWER(:query) || '%' OR
        UPPER(:query) == symbol
    """
    )
    suspend fun searchCompanyListing(query: String): List<CompanyListing>


}
package com.sullivankw.CryptoWalletTracker.repos;

import com.sullivankw.CryptoWalletTracker.models.CryptoParentEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CryptoParentRepo extends PagingAndSortingRepository<CryptoParentEntity, UUID> {

}

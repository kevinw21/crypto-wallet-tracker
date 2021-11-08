package com.sullivankw.CryptoWalletTracker.repos;

import com.sullivankw.CryptoWalletTracker.models.CryptoParentEntity;
import com.sullivankw.CryptoWalletTracker.models.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CryptoParentRepo extends JpaRepository<CryptoParentEntity, UUID> {

    Optional<CryptoParentEntity> findBySymbolAndWallet(String symbol, Wallet wallet);
}

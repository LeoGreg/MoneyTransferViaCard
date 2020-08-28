package com.example.money.repository;

import com.example.money.model.active.TransferStory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferRepository extends JpaRepository<TransferStory, Integer> {

    List<TransferStory> getBySenderN(String senderN);

    List<TransferStory> getByGetterN(String getterN);

    TransferStory getById(int id);


}

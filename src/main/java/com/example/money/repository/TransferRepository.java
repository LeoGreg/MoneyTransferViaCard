package com.example.money.repository;

import com.example.money.model.active.TransferStory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferRepository extends JpaRepository<TransferStory, Integer> {

    List<TransferStory> getBySenderNAndSenderNameAndSenderSurnameAndSenderId(String num, String name, String surname,int userId);

    List<TransferStory> getBySenderN(String getterN);

    TransferStory getById(int id);


}

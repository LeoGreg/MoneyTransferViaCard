package com.example.money.model.active;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@Entity
public class TransferStory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int id;

    @NotBlank
    @Pattern(regexp = "[0-9]{12}")
    private String senderN;

    @NotBlank
    @Pattern(regexp = "[0-9]{5}")
    private String getterN;

    private double money;

    private int senderId;
    private String senderName;
    private String senderSurname;

    private double senderBalanceBeforeTransaction;
    private double senderBalanceAfterTransaction;
    private double getterBalanceBeforeTransaction;
    private double getterBalanceAfterTransaction;

    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationTime;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
}

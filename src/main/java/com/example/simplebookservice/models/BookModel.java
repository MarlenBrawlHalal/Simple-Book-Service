package com.example.simplebookservice.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "book")
public class BookModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @NotNull
  @Size(min = 1, max = 200)
  private String title;

  @NotNull
  @Size(min = 1, max = 200)
  private String author;

  @NotNull
  @Size(min = 1, max = 1000)
  private String description;

  @NotNull
  private double price;
}

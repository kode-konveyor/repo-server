package com.kodekonveyor.repo.api;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import lombok.Data;

@Entity
@Data
public class BridiEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private SumtiEntity selbri;

  @OrderColumn
  @OneToMany(fetch = FetchType.LAZY)
  private List<SumtiEntity> sumti;
}

package com.kodekonveyor.repo.backend.api.lookup;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodekonveyor.exception.ValidationException;
import com.kodekonveyor.repo.api.LerpoiEntity;
import com.kodekonveyor.repo.api.LerpoiEntityRepository;
import com.kodekonveyor.repo.api.SumtiConstants;
import com.kodekonveyor.repo.api.SumtiDTO;
import com.kodekonveyor.repo.api.SumtiEntity;
import com.kodekonveyor.repo.api.SumtiEntityRepository;

@Service
public class LookupRepositoryByNameService {

  @Autowired
  private LerpoiEntityRepository lerpoiEntityRepository;

  @Autowired
  private SumtiEntityRepository sumtiEntityRepository;

  public List<SumtiDTO> call(final String repoName) {
    final Optional<LerpoiEntity> lerpoiEntity =
        lerpoiEntityRepository.findByName(repoName);
    if (lerpoiEntity.isEmpty())
      throw new ValidationException(SumtiConstants.LERPOI_NOT_FOUND_EXCEPTION);

    final List<SumtiEntity> sumtiEntity =
        sumtiEntityRepository.findByLerpoi(lerpoiEntity.get());
    if (sumtiEntity.isEmpty())
      throw new ValidationException(SumtiConstants.SUMTI_NOT_FOUND_EXCEPTION);
    final List<SumtiDTO> sumtiDTOList = new ArrayList<>();
    for (final SumtiEntity sumti : sumtiEntity)
      sumtiDTOList.add(convertEnityToDTO(sumti));

    return sumtiDTOList;

  }

  private SumtiDTO convertEnityToDTO(final SumtiEntity sumti) {
    final SumtiDTO sumtiDTO = new SumtiDTO();
    sumtiDTO.setBridi(sumti.getBridi().getId());
    sumtiDTO.setLerpoi(sumti.getLerpoi().getId());
    sumtiDTO.setUuid(sumti.getUuid());
    return sumtiDTO;
  }
}

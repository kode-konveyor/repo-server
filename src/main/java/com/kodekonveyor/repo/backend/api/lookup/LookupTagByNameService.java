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
public class LookupTagByNameService {

  @Autowired
  private LerpoiEntityRepository lerpoiEntityRepository;

  @Autowired
  private SumtiEntityRepository sumtiEntityRepository;

  public List<SumtiDTO> call(final String repoName) {
    final Optional<LerpoiEntity> lerpoiEntity =
        lerpoiEntityRepository.findByName(repoName);
    if (lerpoiEntity.isEmpty())
      throw new ValidationException(
          SumtiConstants.LERPOI_NOT_FOUND_EXCEPTION_FOR_TAG_LOOKUP
      );
    final List<SumtiEntity> sumtiEntity =
        sumtiEntityRepository.findByLerpoi(lerpoiEntity.get());
    if (sumtiEntity.isEmpty())
      throw new ValidationException(
          SumtiConstants.SUMTI_NOT_FOUND_EXCEPTION_FOR_TAG_LOOKUP
      );
    final List<SumtiDTO> sumtiDTOS = new ArrayList<>();
    for (final SumtiEntity sumti : sumtiEntity)
      sumtiDTOS.add(createDTOConversion(sumti));
    return sumtiDTOS;

  }

  private SumtiDTO createDTOConversion(final SumtiEntity sumtiEntity) {
    final SumtiDTO sumtiDTO = new SumtiDTO();
    sumtiDTO.setBridi(sumtiEntity.getBridi().getId());
    sumtiDTO.setLerpoi(sumtiEntity.getLerpoi().getId());
    sumtiDTO.setUuid(sumtiEntity.getUuid());
    return sumtiDTO;
  }
}

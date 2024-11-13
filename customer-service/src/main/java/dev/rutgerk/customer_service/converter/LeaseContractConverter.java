package dev.rutgerk.customer_service.converter;

import java.util.List;
import org.springframework.stereotype.Component;
import dev.rutgerk.customer_service.dto.LeaseContractDto;
import dev.rutgerk.customer_service.model.LeaseContract;

@Component
public class LeaseContractConverter {

  public LeaseContractDto convert(LeaseContract leaseContract) {
    return LeaseContractDto.builder().id(leaseContract.getId())
        .customerId(leaseContract.getCustomerId()).carTypeId(leaseContract.getCarTypeId())
        .mileagePerYear(leaseContract.getMileagePerYear())
        .durationMonths(leaseContract.getDurationMonths())
        .interestRate(leaseContract.getInterestRate()).startDate(leaseContract.getStartDate())
        .priceNett(leaseContract.getPriceNett()).rate(leaseContract.getRate()).build();
  }

  public LeaseContract convert(LeaseContractDto leaseContractDto) {
    return LeaseContract.builder().id(leaseContractDto.getId())
        .customerId(leaseContractDto.getCustomerId()).carTypeId(leaseContractDto.getCarTypeId())
        .mileagePerYear(leaseContractDto.getMileagePerYear())
        .durationMonths(leaseContractDto.getDurationMonths())
        .interestRate(leaseContractDto.getInterestRate()).startDate(leaseContractDto.getStartDate())
        .priceNett(leaseContractDto.getPriceNett()).rate(leaseContractDto.getRate()).build();
  }

  public List<LeaseContractDto> convertAllModels(List<LeaseContract> leaseContracts) {
    return leaseContracts.stream().map(this::convert).toList();
  }

  public List<LeaseContract> convertAllDtos(List<LeaseContractDto> leaseContractsDtos) {
    return leaseContractsDtos.stream().map(this::convert).toList();
  }

}



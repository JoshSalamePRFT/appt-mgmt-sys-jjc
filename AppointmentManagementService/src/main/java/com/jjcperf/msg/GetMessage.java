package com.jjcperf.msg;

import com.jjcperf.msg.enums.CriteriaTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetMessage implements Serializable  {
    static final long serialVersionUID = -4454698975132L;

    private UUID id;
    private CriteriaTypeEnum criteriaType;
    private String message;
}

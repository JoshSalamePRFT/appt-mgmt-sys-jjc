package com.jjcperf.msg.msg.appt;

import com.jjcperf.msg.enums.CriteriaTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApptGetAllMessage implements Serializable {
    static final long serialVersionUID = -4454698975132L;

    private CriteriaTypeEnum criteriaType;
    private String message;
}

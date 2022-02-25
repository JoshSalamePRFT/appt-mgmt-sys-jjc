package com.jjcperf.msg.msg.appt;

import com.jjcperf.apptGroup.model.Appointment;
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
public class ApptPostMessage implements Serializable {
    static final long serialVersionUID = -4454698975132L;

    private Appointment appt;
    private CriteriaTypeEnum criteriaType;
    private String message;
}

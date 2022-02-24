package com.jjcperf.msg.msg;

import com.jjcperf.userservice.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMessage<E extends BaseEntity> implements Serializable {

    static final long serialVersionUID = -78655435786458L;

    private UUID id;
    private List<E> entities;

    public E entity() {
        if(!entities.isEmpty()){
            return entities.get(0);
        }
        else return null;
    }
}

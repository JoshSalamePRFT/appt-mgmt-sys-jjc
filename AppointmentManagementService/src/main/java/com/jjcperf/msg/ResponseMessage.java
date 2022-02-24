package com.jjcperf.msg;

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
public class ResponseMessage implements Serializable {

    static final long serialVersionUID = -78655435786458L;

    private UUID id;
    private List<Object> objs;

    public Object obj() {
        if(!objs.isEmpty()){
            return objs.get(0);
        }
        else return null;
    }
}

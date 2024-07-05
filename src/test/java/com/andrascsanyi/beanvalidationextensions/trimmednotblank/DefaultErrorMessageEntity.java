package com.andrascsanyi.beanvalidationextensions.trimmednotblank;

import com.andrascsanyi.beanvalidationextensions.TrimmedNotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DefaultErrorMessageEntity {

    @TrimmedNotBlank
    private String id;
}

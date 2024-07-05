package com.andrascsanyi.beanvalidationextensions.trimmedsize;

import com.andrascsanyi.beanvalidationextensions.TrimmedSize;
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

    @TrimmedSize(min = 1, max = 2)
    private String id;
}

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
public class CustomErrorMessageEntity {

    @TrimmedSize(min = 1, max = 2, message = "Custom Error Message")
    private String id;
}

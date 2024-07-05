package com.andrascsanyi.beanvalidationextensions.trimmednotempty;

import com.andrascsanyi.beanvalidationextensions.TrimmedNotEmpty;
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

    @TrimmedNotEmpty
    private String id;
}

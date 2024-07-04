package com.andrascsanyi.beanvalidationextensions.longvaluemustbeequalorgreaterto;

import com.andrascsanyi.beanvalidationextensions.LongValueMustBeGreaterOrEqualTo;
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
    
    @LongValueMustBeGreaterOrEqualTo(
        mustBeGreaterOrEqualTo = 1
    )
    private Long id;
}

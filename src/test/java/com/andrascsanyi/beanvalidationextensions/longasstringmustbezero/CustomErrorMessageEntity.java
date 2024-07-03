package com.andrascsanyi.beanvalidationextensions.longasstringmustbezero;

import com.andrascsanyi.beanvalidationextensions.LongAsStringMustBeZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomErrorMessageEntity {

    @LongAsStringMustBeZero(message = "Custom Error Message")
    private String id;
}

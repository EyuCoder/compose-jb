/*
 * Copyright 2020-2021 JetBrains s.r.o. and respective authors and developers.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE.txt file.
 */

package androidx.compose.web.attributes

import org.jetbrains.compose.web.attributes.*
import org.w3c.dom.HTMLInputElement

class SyntaxInputEvent<ValueType>(val value: ValueType)

class InputAttrsBuilder<T>(val inputType2: InputType2<T>) : AttrsBuilder<HTMLInputElement>() {
    fun onSyntheticInput(options: Options = Options.DEFAULT, f: (SyntaxInputEvent<T>) -> Unit) {
        addEventListener(INPUT, options) {
            val value = inputType2.inputValue(it.nativeEvent)
            f(SyntaxInputEvent(value))
        }
    }
}

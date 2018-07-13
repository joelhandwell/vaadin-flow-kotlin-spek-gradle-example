package com.github.joelhandwell

import com.github.karibu.testing.v10.MockVaadin
import com.github.karibu.testing.v10.Routes
import com.github.karibu.testing.v10._click
import com.github.karibu.testing.v10._get
import com.vaadin.flow.component.UI
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.html.Label
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertEquals
import kotlin.test.expect

object HelloViewTest : Spek({

    describe("HelloView"){

        beforeGroup { MockVaadin.setup(Routes().autoDiscoverViews(packageName())) }

        it("changes Label text when Button is clicked"){
            val main = UI.getCurrent().children.findFirst().get() as HelloView
            expect(2) { main.children.count() }
            _get<Button> { caption = "Click me" } ._click()
            expect("Clicked!") { _get<Label>().text }
        }
    }
})

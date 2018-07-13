package com.github.joelhandwell

import com.vaadin.flow.component.UI
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.dependency.HtmlImport
import com.vaadin.flow.component.html.Label
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.page.BodySize
import com.vaadin.flow.component.page.Viewport
import com.vaadin.flow.router.Route
import com.vaadin.flow.server.VaadinServlet
import com.vaadin.flow.server.VaadinServletConfiguration
import com.vaadin.flow.theme.Theme
import com.vaadin.flow.theme.lumo.Lumo
import javax.servlet.annotation.WebServlet

class Package; fun packageName() = Package::class.java.`package`.name!!

@WebServlet(urlPatterns = ["/*"], name = "HelloServlet", asyncSupported = true)
@VaadinServletConfiguration(ui = HelloUI::class, productionMode = false)
class HelloServlet : VaadinServlet()

@HtmlImport("index.html")
@Theme(Lumo::class)
class HelloUI : UI()

@Route("")
@BodySize(height = "100vh", width = "100vw")
@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
class HelloView : VerticalLayout(){
    init {
        className = "app-view"
        val hello = Label("Package Gradle App!")
        add(hello)

        val button = Button("Click me") {
            hello.text = "Clicked!"
        }
        add(button)
    }
}

package nl.avisi.structurizr.site.generatr.site.views

import kotlinx.html.*
import nl.avisi.structurizr.site.generatr.site.model.HomePageViewModel

fun HTML.homePage(viewModel: HomePageViewModel) {
    page(viewModel) {
        contentDiv {
            rawHtml(viewModel.content)
        }
    }
}


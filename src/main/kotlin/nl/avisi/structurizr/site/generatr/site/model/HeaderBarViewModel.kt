package nl.avisi.structurizr.site.generatr.site.model

import nl.avisi.structurizr.site.generatr.site.GeneratorContext

class HeaderBarViewModel(pageViewModel: PageViewModel, generatorContext: GeneratorContext) {
    val url = pageViewModel.url
    val relativeTo = pageViewModel.relativeTo
    val logo = logoPath(generatorContext)?.let { ImageViewModel(pageViewModel, "/$it") }
    val hasLogo = logo != null
    val titleLink = LinkViewModel(pageViewModel, generatorContext.workspace.name, HomePageViewModel.url())
    val searchLink = LinkViewModel(pageViewModel, generatorContext.workspace.name, SearchViewModel.url())
    val returnLink = generatorContext.returnLink
    val branches = generatorContext.branches
        .map { BranchHomeLinkViewModel(pageViewModel, it) }
    val currentBranch = generatorContext.currentBranch
    val categories = generatorContext.categories.map {
        val title = it.uppercase()

        Pair(
            LinkViewModel(pageViewModel, title, "/$relativeTo$it/$currentBranch"),
            title.equals(generatorContext.workspace.name, ignoreCase = true)
        )
    }
    val version = generatorContext.version
    val allowToggleTheme = pageViewModel.allowToggleTheme

    private fun logoPath(generatorContext: GeneratorContext) =
        generatorContext.workspace.views.configuration.properties
            .getOrDefault(
                "generatr.style.logoPath",
                null
            )
}

object Dependencies {

    val androidxCoreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
    val androidxAppCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val androidLifecycleRuntimeKtx by lazy { "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycleRuntimeKtx}" }
    val androidxActivityCompose by lazy { "androidx.activity:activity-compose:${Versions.activityCompose}" }
    val androidxComposeBom by lazy { "androidx.compose:compose-bom:${Versions.composeBom}" }
    val androidxComposeUi by lazy { "androidx.compose.ui:ui" }
    val androidxComposeUiGraphics by lazy { "androidx.compose.ui:ui-graphics" }
    val androidxComposeUiToolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview" }
    val androidxComposeMaterial3 by lazy { "androidx.compose.material3:material3" }
    val androidxNavigationCompose by lazy { "androidx.navigation:navigation-compose:${Versions.navigationCompose}" }
    val lifecycleViewModelKtx by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleViewModelKtx}" }

    val androidxComposeUiTestJUnit4 by lazy { "androidx.compose.ui:ui-test-junit4" }

    val androidxComposeUiTooling by lazy { "androidx.compose.ui:ui-tooling" }
    val androidxComposeUiTestManifest by lazy { "androidx.compose.ui:ui-test-manifest" }
}
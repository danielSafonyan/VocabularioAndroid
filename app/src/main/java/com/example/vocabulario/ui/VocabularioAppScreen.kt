package com.example.vocabulario.ui

import android.content.Context
import android.content.Intent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.vocabulario.R
import com.example.vocabulario.ui.screens.MainScreen
import com.example.vocabulario.ui.screens.PracticeScreen
import com.example.vocabulario.ui.screens.ProfileScreen
import com.example.vocabulario.ui.screens.WordListScreen

/**
 * enum values that represent the screens in the app
 */
enum class VocabularioScreens(@StringRes val title: Int) {
    Main(title = R.string.app_name),
    Profile(title = R.string.profile_screen),
    Practice(title = R.string.practice_screen),
    WordList(title = R.string.word_list_screen)
}

/**
 * Composable that displays the topBar and displays back button if back navigation is possible.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VocabularioAppBar(
    currentScreen: VocabularioScreens,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    navigateProfile: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
//        title = { Text(stringResource(currentScreen.title)) },
        title = { Text("") },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        actions = {
           if(currentScreen.name == "Main") {
                IconButton(onClick = navigateProfile) {
                    Icon(
                        imageVector = Icons.Filled.AccountCircle,
                        contentDescription = stringResource(R.string.profile_btn)
                    )
                }
            }
        },
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_btn)
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VocabularioApp(
    viewModel: GameModelView = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = VocabularioScreens.valueOf(
        backStackEntry?.destination?.route ?: VocabularioScreens.Main.name
    )

    Scaffold(
        topBar = {
            VocabularioAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateProfile = { navController.navigate(VocabularioScreens.Profile.name) },
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = VocabularioScreens.Main.name,
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            composable(route = VocabularioScreens.Main.name) {
                MainScreen(
                    onPracticeClick = { navController.navigate(VocabularioScreens.Practice.name) },
                    onWordListClick = { navController.navigate(VocabularioScreens.WordList.name) }
                )
            }
            composable(route = VocabularioScreens.Profile.name) {
                ProfileScreen()
            }
            composable(route = VocabularioScreens.Practice.name) {
                PracticeScreen()
            }
            composable(route = VocabularioScreens.WordList.name) {
                WordListScreen()
            }
        }
    }
}

/**
 * Resets the [OrderUiState] and pops up to [CupcakeScreen.Start]
 */
//private fun cancelOrderAndNavigateToStart(
//    viewModel: OrderViewModel,
//    navController: NavHostController
//) {
//    viewModel.resetOrder()
//    navController.popBackStack(CupcakeScreen.Start.name, inclusive = false)
//}

/**
 * Creates an intent to share order details
 */
//private fun shareOrder(context: Context, subject: String, summary: String) {
//    // Create an ACTION_SEND implicit intent with order details in the intent extras
//    val intent = Intent(Intent.ACTION_SEND).apply {
//        type = "text/plain"
//        putExtra(Intent.EXTRA_SUBJECT, subject)
//        putExtra(Intent.EXTRA_TEXT, summary)
//    }
//    context.startActivity(
//        Intent.createChooser(
//            intent,
//            context.getString(R.string.new_cupcake_order)
//        )
//    )
//}

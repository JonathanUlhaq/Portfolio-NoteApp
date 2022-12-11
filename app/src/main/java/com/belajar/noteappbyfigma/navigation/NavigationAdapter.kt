package com.belajar.noteappbyfigma.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.belajar.noteappbyfigma.models.NoteModel
import com.belajar.noteappbyfigma.route.ADD
import com.belajar.noteappbyfigma.route.DETAIL
import com.belajar.noteappbyfigma.route.HOME
import com.belajar.noteappbyfigma.scene.AddScreen
import com.belajar.noteappbyfigma.scene.DetailScreen
import com.belajar.noteappbyfigma.scene.NoteScreen
import com.belajar.noteappbyfigma.scene.NoteViewModel
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavigationAdapter(
    noteList:List<NoteModel>,
    valueSearch:String,
    onValueChange:(String) -> Unit,
    addNote:(NoteModel) -> Unit,
    noteDetail:List<NoteModel>,
    viewModel:NoteViewModel,
    homeVM:NoteViewModel,
    updateNote:(NoteModel) -> Unit
) {
   val navController = rememberAnimatedNavController()
    AnimatedNavHost(navController = navController,
        startDestination = HOME.route ) {
        composable(HOME.route,
            enterTransition = {
                slideIntoContainer(AnimatedContentScope.SlideDirection.Right, tween(700))
            },
            exitTransition = {
                slideOutOfContainer(AnimatedContentScope.SlideDirection.Up, tween(700))
            }) {
            NoteScreen(noteList =noteList,
                        navController = navController,
                        valueSearch = valueSearch,
                        noteVm = homeVM,
                        onValueChange = {onValueChange.invoke(it)} )
        }
        
        composable(ADD.route,
            enterTransition = {
                slideIntoContainer(AnimatedContentScope.SlideDirection.Up, tween(700))
            },
            exitTransition = {
                slideOutOfContainer(AnimatedContentScope.SlideDirection.Right, tween(700))
            }) {
            AddScreen(navController = navController,addNote)
        }

        composable(DETAIL.route +"/{id}",
            enterTransition = {
                slideIntoContainer(AnimatedContentScope.SlideDirection.Right, tween(700))
            },
            exitTransition = {
                slideOutOfContainer(AnimatedContentScope.SlideDirection.Right, tween(700))
            },
            arguments = listOf(navArgument("id") {
                type = NavType.StringType
            })
        ) { arg->
            arg.arguments?.getString("id")?.let { DetailScreen(id = it,
            navController = navController,
            noteList = noteDetail,
            viewModel = viewModel,
            updateNote = updateNote) }
        }
    }

}
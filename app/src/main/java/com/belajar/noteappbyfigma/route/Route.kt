package com.belajar.noteappbyfigma.route

sealed class Route(val route: String)
object HOME:Route("home")
object ADD:Route("add")
object DETAIL:Route("detail")

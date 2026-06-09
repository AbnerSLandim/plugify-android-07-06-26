package com.example.plugify

import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.platform.LocalContext

import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

@Composable
fun MapaScreen() {

    val context = LocalContext.current

    AndroidView(
        factory = {

            Configuration.getInstance().userAgentValue =
                context.packageName

            val map = MapView(context)

            map.setTileSource(TileSourceFactory.MAPNIK)

            map.controller.setZoom(14.0)

            val centroSP = GeoPoint(
                -23.55052,
                -46.63330
            )

            map.controller.setCenter(centroSP)

            val marker = Marker(map)

            marker.position = centroSP
            marker.title = "Área monitorada"

            map.overlays.add(marker)

            map
        }
    )
}
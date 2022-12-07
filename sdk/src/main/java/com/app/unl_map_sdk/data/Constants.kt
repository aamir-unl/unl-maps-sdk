package com.app.unl_map_sdk.data

import com.app.unl_map_sdk.data.ZoomLevel.MIN_GRID_ZOOM_GEOHASH_LENGTH_5

object Constants {
    val BASE_URL = "https://alpha.platform.unl.global/"
    val TERRAIN = "${BASE_URL}map_styles_terrain.json"
    val BASE = "${BASE_URL}map_styles_base.json"
    val TRAFFIC = "${BASE_URL}map_styles_traffic.json"
    val SATELLITE = "${BASE_URL}map_styles_satellite.json"
    val VECTORIAL = "${BASE_URL}map_styles_vectorial.json"
}

fun getFormattedCellDimensions(cellPrecision: CellPrecision): String {
    when (cellPrecision) {
        CellPrecision.GEOHASH_LENGTH_1 ->
            return "5,009.4km x 4,992.6km"
        CellPrecision.GEOHASH_LENGTH_2 ->
            return "1,252.3km x 624.1km"
        CellPrecision.GEOHASH_LENGTH_3 ->
            return "156.5km x 156km"
        CellPrecision.GEOHASH_LENGTH_4 ->
            return "39.1km x 19.5km"
        CellPrecision.GEOHASH_LENGTH_5 ->
            return "4.9km x 4.9km"
        CellPrecision.GEOHASH_LENGTH_6 ->
            return "1.2km x 609.4m"
        CellPrecision.GEOHASH_LENGTH_7 ->
            return "152.9m x 152.4m"
        CellPrecision.GEOHASH_LENGTH_8 ->
            return "38.2m x 19m"
        CellPrecision.GEOHASH_LENGTH_10 ->
            return "1.2m x 59.5cm"
        else -> return "4.8m x 4.8m"
    }
}

fun getMinGridZoom(cellPrecision: CellPrecision): ZoomLevel {
    when (cellPrecision) {
        CellPrecision.GEOHASH_LENGTH_10 ->
            return ZoomLevel.MIN_GRID_ZOOM_GEOHASH_LENGTH_10
        CellPrecision.GEOHASH_LENGTH_8 ->
            return ZoomLevel.MIN_GRID_ZOOM_GEOHASH_LENGTH_8
        CellPrecision.GEOHASH_LENGTH_7 ->
            return ZoomLevel.MIN_GRID_ZOOM_GEOHASH_LENGTH_7
        CellPrecision.GEOHASH_LENGTH_6 ->
            return ZoomLevel.MIN_GRID_ZOOM_GEOHASH_LENGTH_6
        CellPrecision.GEOHASH_LENGTH_5 ->
            return MIN_GRID_ZOOM_GEOHASH_LENGTH_5
        CellPrecision.GEOHASH_LENGTH_4 ->
            return ZoomLevel.MIN_GRID_ZOOM_GEOHASH_LENGTH_4
        CellPrecision.GEOHASH_LENGTH_3 ->
            return ZoomLevel.MIN_GRID_ZOOM_GEOHASH_LENGTH_3
        CellPrecision.GEOHASH_LENGTH_2 ->
            return ZoomLevel.MIN_GRID_ZOOM_GEOHASH_LENGTH_2
        CellPrecision.GEOHASH_LENGTH_1 ->
            return ZoomLevel.MIN_GRID_ZOOM_GEOHASH_LENGTH_1
        else ->
            return ZoomLevel.MIN_GRID_ZOOM_GEOHASH_LENGTH_9
    }
}

fun getZoomLevels(): HashMap<ZoomLevel, Int> {
    var zooms = HashMap<ZoomLevel,Int>()
    zooms[ZoomLevel.MIN_GRID_ZOOM_GEOHASH_LENGTH_10] = 20
    zooms[ZoomLevel.MIN_GRID_ZOOM_GEOHASH_LENGTH_9] = 18
    zooms[ZoomLevel.MIN_GRID_ZOOM_GEOHASH_LENGTH_8] = 16
    zooms[ZoomLevel.MIN_GRID_ZOOM_GEOHASH_LENGTH_7] = 14
    zooms[ZoomLevel.MIN_GRID_ZOOM_GEOHASH_LENGTH_6] = 12
    zooms[ZoomLevel.MIN_GRID_ZOOM_GEOHASH_LENGTH_5] = 10
    zooms[ZoomLevel.MIN_GRID_ZOOM_GEOHASH_LENGTH_4] = 8
    zooms[ZoomLevel.MIN_GRID_ZOOM_GEOHASH_LENGTH_3] = 4
    zooms[ZoomLevel.MIN_GRID_ZOOM_GEOHASH_LENGTH_2] = 3
    zooms[ZoomLevel.MIN_GRID_ZOOM_GEOHASH_LENGTH_1] = 2
    return zooms
}

fun getCellPrecisions():  HashMap<CellPrecision,Int> {
    var precisions = HashMap<CellPrecision,Int>()
    precisions[CellPrecision.GEOHASH_LENGTH_10] = 10
    precisions[CellPrecision.GEOHASH_LENGTH_9] = 9
    precisions[CellPrecision.GEOHASH_LENGTH_8] = 8
    precisions[CellPrecision.GEOHASH_LENGTH_7] = 7
    precisions[CellPrecision.GEOHASH_LENGTH_6] = 6
    precisions[CellPrecision.GEOHASH_LENGTH_5] = 5
    precisions[CellPrecision.GEOHASH_LENGTH_4] = 4
    precisions[CellPrecision.GEOHASH_LENGTH_3] = 3
    precisions[CellPrecision.GEOHASH_LENGTH_2] = 2
    precisions[CellPrecision.GEOHASH_LENGTH_1] = 1
    return precisions
}

enum class ZoomLevel {
    MIN_GRID_ZOOM_GEOHASH_LENGTH_10,
    MIN_GRID_ZOOM_GEOHASH_LENGTH_9,
    MIN_GRID_ZOOM_GEOHASH_LENGTH_8,
    MIN_GRID_ZOOM_GEOHASH_LENGTH_7,
    MIN_GRID_ZOOM_GEOHASH_LENGTH_6,
    MIN_GRID_ZOOM_GEOHASH_LENGTH_5,
    MIN_GRID_ZOOM_GEOHASH_LENGTH_4,
    MIN_GRID_ZOOM_GEOHASH_LENGTH_3,
    MIN_GRID_ZOOM_GEOHASH_LENGTH_2,
    MIN_GRID_ZOOM_GEOHASH_LENGTH_1
}

enum class CellPrecision {
    GEOHASH_LENGTH_10,
    GEOHASH_LENGTH_9,
    GEOHASH_LENGTH_8,
    GEOHASH_LENGTH_7,
    GEOHASH_LENGTH_6,
    GEOHASH_LENGTH_5,
    GEOHASH_LENGTH_4,
    GEOHASH_LENGTH_3,
    GEOHASH_LENGTH_2,
    GEOHASH_LENGTH_1
}

enum class SourceIDs {
    GRID_SOURCE_ID,CELL_SOURCE_ID
}
enum class LayerIDs {
    GRID_LAYER_ID,CELL_LAYER_ID
}

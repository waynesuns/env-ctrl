////////////////////////////////////////////
//趋势图
////////////////////////////////////////////

var serieName = "serie";

/**
 * 柱状图
 * 
 * @param id
 * @param number
 * @param tooltipsName
 * @param valuesVal
 */
function histogramChart(id, number, tooltipsName, valuesVal, labelsName, colorName) {
	var series = generateSerie(number);
	var tooltipJSON = generateJSONByString(series, tooltipsName);
	var valueJSON = generateJSONByInteger(series, valuesVal);
	initTemplate(series, colorName);
	$("#" + id).chart({
		template : "line_basic_5",
		tooltips : tooltipJSON.items,
		values : valueJSON.items,
		labels : labelsName,
		defaultSeries : {
			type : "bar"
		},
		barMargins : 10
	});
}

/**
 * 根据字符串数组类型的数据生成JSON
 * 
 * @param jsonKey
 *            json的名称
 * @param jsonVal
 *            json的值
 * @returns
 */
function generateJSONByString(jsonKey, jsonVal) {
	var json = "";
	json += "{";
	json += "\"items\":";
	json += "{";
	for ( var i = 0; i < jsonKey.length; i++) {
		var key = jsonKey[i];
		json += "\"" + key + "\":";
		json += "[";
		for ( var j = 0; j < jsonVal[i].length; j++) {
			json += "\"" + jsonVal[i][j] + "\"";
			if (j != jsonVal[i].length - 1)
				json += ",";
		}
		json += "]";
		if (i != jsonKey.length - 1) {
			json += ",";
		}
	}
	json += "}";
	json += "}";
	return eval("(" + json + ")");
}

function generateJSONSingleByString(jsonKey, jsonVal) {
	var json = "";
	json += "{";
	json += "\"items\":";
	json += "{";
	for ( var i = 0; i < jsonKey.length; i++) {
		var key = jsonKey[i];
		json += "\"" + key + "\":";
		json += "{\"color\":";
		json += "\"" + jsonVal[i] + "\"";
		json += "}";
		if (i != jsonKey.length - 1) {
			json += ",";
		}
	}
	json += "}";
	json += "}";
	return eval("(" + json + ")");
}

/**
 * 根据数字类型数组类型的数据生成JSON
 * 
 * @param jsonKey
 *            json的名称
 * @param jsonVal
 *            json的值
 * @returns JSON
 */
function generateJSONByInteger(jsonKey, jsonVal) {
	var json = "";
	json += "{";
	json += "\"items\":";
	json += "{";
	for ( var i = 0; i < jsonKey.length; i++) {
		var key = jsonKey[i];
		json += "\"" + key + "\":";
		json += "[";
		json += jsonVal[i];
		json += "]";
		if (i != jsonKey.length - 1) {
			json += ",";
		}
	}
	json += "}";
	json += "}";
	return eval("(" + json + ")");
}

/**
 * 生成SerieName
 * 
 * @param number
 *            个数、长度
 * @returns {Array}
 */
function generateSerie(number) {
	var series = new Array(number);
	for ( var i = 0; i < number; i++) {
		series[i] = serieName + (i + 1);
	}
	return series;
}

/**
 * 初始化模板
 */
function initSimpleTemplate(series, colors) {
	var colorJSON = generateJSONSingleByString(series, colors);
	$.elycharts.templates['line_basic_5'] = {
		type : "line",
		margins : [ 10, 100, 20, 50 ],
		style : {
			background : "#fff"
		},
		defaultSeries : {
			plotProps : {
				opacity : 0.6
			},
			highlight : {
				overlayProps : {
					fill : "white",
					opacity : 0.5
				}
			},
			startAnimation : {
				active : false,
				type : "grow"
			},
			tooltip : {
				frameProps : false,
				height : 20,
				offset : [ 10, 0 ],
				contentStyle : "font-weight: bold"
			}
		},
		series : colorJSON.items,
		defaultAxis : {
			labels : true
		},
		features : {
			grid : {
				draw : true,
				forceBorder : true,
				ny : 5
			}
		},
		legend : {
			horizontal : false,
			width : 90,
			height : 90,
			x : 345,
			borderProps : {
				"fill-opacity" : 0.3
			}
		}
	};
}

function initMixedAndLineTemplate() {
	$.elycharts.templates['line_basic_6'] = {
		type : "line",
		margins : [ 10, 40, 40, 30 ],
		defaultSeries : {
			highlight : {
				newProps : {
					r : 8,
					opacity : 1
				},
				overlayProps : {
					fill : "white",
					opacity : 0.2
				}
			}
		},
		series : {
			serie1 : {
				color : "90-#003000-#009000",
				tooltip : {
					frameProps : {
						stroke : "green"
					}
				}
			},
			serie2 : {
				color : "90-#000060-#0000B0",
				tooltip : {
					frameProps : {
						stroke : "blue"
					}
				}
			},
			serie3 : {
				color : "red",
				rounded : false,
				dot : true,
				dotProps : {
					r : 0,
					stroke : "white",
					"stroke-width" : 0,
					opacity : 0
				},
				plotProps : {
					"stroke-width" : 4,
					"stroke-linecap" : "round",
					"stroke-linejoin" : "round"
				}
			}
		},
		defaultAxis : {
			labels : true
		},
		axis : {
			x : {
				labelsRotate : 45,
				labelsProps : {
					font : "12px Verdana"
				}
			}
		},
		features : {
			grid : {
				draw : true,
				forceBorder : true,
				ny : 5
			},
			legend : {
				horizontal : false,
				width : 90,
				height : 80,
				x : 310,
				borderProps : {
					"fill-opacity" : 0.3
				}
			}
		},
		barMargins : 10
	};
}

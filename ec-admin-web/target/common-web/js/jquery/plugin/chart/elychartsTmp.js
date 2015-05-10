var colors=["#FF6600","#92CF00","#41DACD","#D40488","#8000ED","#D9e01D","#8B008B","#556B2F","#FF8C00","#00FFFF",
            "#BA2BE2","#A52A2A","#DEB887","#5F9EA0","#7FFF00","#6495ED",
            "#FFF8DC","#DC143C","#00008B","#008B8B","#B8860B","#A9A9A9","#006400","#BDB76B","#9932CC","#BB0000",
            "#E9967A","#8FBC8F","#483DBB","#2F4F4F","#00CED1","#9400D3","#FF1493","#00BFFF","#696969","#1E90FF",
            "#D19275","#B22222","#228B22","#FF00FF","#DCDCDC","#FFD700","#DAA520","#808080","#008000","#ADFF2F",
            "#FF6984","#CD5C5C","#4B0082","#FFFFF0","#F0E68C","#E6E6FA","#FFF0F5","#7CFC00","#FFFACD","#ADD8E6",
            "#F08080","#E0FFFF","#FAFAD2","#EE82EE","#D02090","#F5DEB3","#F5F5F5","#FFFF00","#9ACD32","#D3D3D3",
            "#90EE90","#FFB6C1","#FFA07A","#20B2AA","#87CEFA","#8470FF","#778899","#B0C4DE","#FFFFE0","#00FF00",
            "#32CD32","#800000","#66CDAA","#0000CD","#BA55D3","#9370DB","#3CB371","#7B68EE","#00FA9A","#4BD1CC",
            "#C71585","#191970","#FFE4E1","#FFE4B5","#808000","#6B8E23","#FFA500","#FF4500","#DA70D6","#EEE8AA",
            "#98FB98","#AFEEEE","#D87093","#FFEFD5","#FFDAB9","#CD853F","#FFC0CB","#DDA0DD","#B0E0E6","#800080",
            "#FF0000","#BC8F8F","#4169E1","#8B4513","#FA8072","#F4A460","#2E8B57","#A0522D","#C0C0C0","#87CEEB",
            "#6A5ACD","#708090","#00FF7F","#4682B4","#D2B48C","#008080"];
var piecolors=new Array();
var othercolors;
var colorjson="{";
$(document).ready(function(){  
	for(var i=0;i<colors.length;i++){
		piecolors.push( {
			   plotProps : {
				    fill : colors[i]
				   }
				  });
		colorjson+="serie" + (i+1) + ":{color:'"+colors[i]+"'},";
	}
	colorjson=colorjson.substring(0, colorjson.length-1);
	colorjson+="}";
	othercolors=eval("("+colorjson+")");
	$.elycharts.templates['pie_basic_1'] = {
			 type : "pie",
			 r: 230,
		      cx:350,
			 defaultSeries : {
			  values:piecolors,
			  plotProps : {
			   stroke : "white",
			   "stroke-width" : 2,
			   opacity : 0.8
			  },
			  highlight : {
			   move : 20
			  },
			  tooltip : {
				  width: 200,
			   frameProps : {
			    opacity : 0.5
			   }
			  }
			 },
			 features : {
			  legend : {
			   horizontal : false,
			   width : 240,
			   height : 550,
			   x :600,
			   y :50,
			   borderProps : {
			    "fill-opacity" : 0.3
			   }
			  }
			 }
			};
	$.elycharts.templates['pie_basic_2'] = {
			 type : "pie",
			 r: 230,
		      cx:350,
			 defaultSeries : {
			  values:piecolors,
			  plotProps : {
			   stroke : "white",
			   "stroke-width" : 0,
			   opacity : 0.8
			  },
			  highlight : {
			   move : 20
			  },
			  tooltip : {
				  width: 200,
			   frameProps : {
			    opacity : 0.5
			   }
			  }
			 },
			 features : {
			  legend : {
			   horizontal : false,
			   width : 240,
			   height : 550,
			   x :600,
			   y :50,
			   borderProps : {
			    "fill-opacity" : 0.3
			   }
			  }
			 }
			};
			$.elycharts.templates['line_basic_6'] = {
			 type : "line",
			 margins : [10, 160, 120, 30],
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
			   color : "green",
			   tooltip : {
			    frameProps : {
			     stroke : "green"
			    }
			   }
			  },
			  serie2 : {
			   color : "#5fd000",
			   tooltip : {
			    frameProps : {
			     stroke : "#5fd000"
			    }
			   }
			  },
			  serie3 : {
			   color : "red",
			   rounded : false,
			   dot : true,
			   dotProps : {
			    r : 1,
			    stroke : "white",
			    "stroke-width" : 0,
			    opacity : 0
			   },
			   plotProps : {
			    "stroke-width" : 2,
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
			   width : 93,
			   height : 80,
			   x : 755,
			   borderProps : {
			    "fill-opacity" : 0.3
			   }
			  }
			 },
			 barMargins : 10
			};
			$.elycharts.templates['line_basic'] = {
			 type : "line",
			 margins : [10, 40, 40, 30],
			 defaultSeries : {
			  plotProps : {
			   "stroke-width" : 4
			  },
			  dot : true,
			  dotProps : {
			   stroke : "white",
			   "stroke-width" : 2
			  }
			 },
			 series : othercolors,
			 defaultAxis : {
			  labels : true
			 },
			 features : {
			  grid : {
			   draw : [true, false],
			   props : {
			    "stroke-dasharray" : "-"
			   }
			  },
			  legend : {
			   horizontal : false,
			   width : 80,
			   height : 50,
			   x : 200,
			   dotType : "circle",
			   dotProps : {
			    stroke : "white",
			    "stroke-width" : 2
			   },
			   borderProps : {
			    opacity : 0.3
			   }
			  }
			 }
			};
			$.elycharts.templates['line_basic_5'] = {
			 type : "line",
			 margins : [10, 160, 120, 50],
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
			  tooltip : {
			   frameProps : false,
			   height : 20,
			   offset : [10, 0],
			   contentStyle : "font-weight: bold"
			  }
			 },
			 series :othercolors,
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
			   width : 135,
			   height : 300,
			   x : 700,
			   borderProps : {
			    "fill-opacity" : 0.3
			   }
			  }
			 }
			};
			$.elycharts.templates['line_basic_8'] = {
					 type : "line",
					 margins : [10, 160, 120, 50],
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
					  tooltip : {
					   frameProps : false,
					   height : 20,
					   offset : [10, 0],
					   contentStyle : "font-weight: bold"
					  }
					 },
					 series :othercolors,
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
					   width : 135,
					   height : 180,
					   x : 700,
					   borderProps : {
					    "fill-opacity" : 0.3
					   }
					  }
					 }
					};
});

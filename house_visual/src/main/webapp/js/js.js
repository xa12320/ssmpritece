 $(window).load(function(){  
             $(".loading").fadeOut()
            })  
			
/****/
$(document).ready(function(){
	var whei=$(window).width()
	$("html").css({fontSize:whei/20})
	$(window).resize(function(){
		var whei=$(window).width()
	 $("html").css({fontSize:whei/20})
});
	});


 $(window).load(function(){$(".loading").fadeOut()})  
$(function () {
    echarts_1()
    echarts_2()
    echarts_3()
    echarts_4()
    echarts_5()
    echarts_6()
    pe01()
    pe02()
    pe03()

function echarts_1() {
        $.get("http://localhost:8080/house/houseMerit",function (data){
            var sh = data.sh;
            var bj = data.bj;
            var gz = data.gz;
            var sz = data.sz;
            var myChart = echarts.init(document.getElementById('echarts1'));

            setTimeout(function () {
                option = {

                    legend: {
                        top: '4%',
                        right: '5%',
                        textStyle: {
                            color:'rgba(255,255,255,.6)'
                        }
                    },
                    tooltip: {
                        trigger: 'axis',
                        showContent: false
                    },
                    dataset: {
                        source: [
                            ['城市', '采光好', '交通便利', '有电梯', '精装房', '景观好', '近公园/社区'],
                            sh,
                            bj,
                            gz,
                            sz
                        ]
                    },
                    xAxis: {
                        type: 'category',
                        name: '优势',
                        splitLine:{
                            show:false,
                            color:	'#FCFCFC'
                        },
                        axisLine: {
                            show:true,
                            lineStyle:{
                                color: 'rgba(255,255,255,.6)'
                            }
                        },
                        axisLabel:{interval: 0}
                    },
                    yAxis: {
                        gridIndex: 0,
                        name: '比例',
                        splitLine:{
                            show:true,
                            color:	'#FCFCFC'
                        },
                        axisLine:{
                            show:true,
                            lineStyle:{
                                color: 'rgba(255,255,255,.6)'
                            }
                        }
                    },
                    grid: {
                        top: '55%'
                    },
                    series: [
                        {
                            type: 'line',
                            smooth: true,
                            seriesLayoutBy: 'row',
                            emphasis: { focus: 'series' }
                        },
                        {
                            type: 'line',
                            smooth: true,
                            seriesLayoutBy: 'row',
                            emphasis: { focus: 'series' }
                        },
                        {
                            type: 'line',
                            smooth: true,
                            seriesLayoutBy: 'row',
                            emphasis: { focus: 'series' }
                        },
                        {
                            type: 'line',
                            smooth: true,
                            seriesLayoutBy: 'row',
                            emphasis: { focus: 'series' }
                        },
                        {
                            type: 'pie',
                            id: 'pie',
                            radius: '30%',
                            center: ['50%', '25%'],
                            emphasis: {
                                focus: 'self'
                            },
                            label: {
                                formatter: '{b}: {@采光好} ({d}%)'
                            },
                            encode: {
                                itemName: '城市',
                                value: '采光好',
                                tooltip: '采光好'
                            }
                        }
                    ]
                };
                myChart.on('updateAxisPointer', function (event) {
                    const xAxisInfo = event.axesInfo[0];
                    if (xAxisInfo) {
                        const dimension = xAxisInfo.value + 1;
                        myChart.setOption({
                            series: {
                                id: 'pie',
                                label: {
                                    formatter: '{b}: {@[' + dimension + ']} ({d}%)'
                                },
                                encode: {
                                    value: dimension,
                                    tooltip: dimension
                                }
                            }
                        });
                    }
                });
                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
            });
        });
}
function echarts_2() {
        $.get("http://localhost:8080/house/houseNorms",function (data){
            var city = data.citys;
            var infos = data.info;
            var sh = data.sh;
            var bj = data.bj;
            var gz = data.gz;
            var sz = data.sz;
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('echarts2'));

            option = {
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {type: 'shadow'},
                    // formatter:'{c}' ,
                },
                grid: {
                    left: '0',
                    top: '30',
                    right: '10',
                    bottom: '-20',
                    containLabel: true
                },
                legend: {
                    data: city,
                    right: 'center',
                    top:0,
                    textStyle: {
                        color: "#fff"
                    },
                    itemWidth: 12,
                    itemHeight: 10,
                    // itemGap: 35
                },

                xAxis: [{
                    type: 'category',
                    boundaryGap: false,
                    axisLabel:  {
                        rotate: 30,
                        textStyle: {
                            color: "rgba(255,255,255,.6)",
                            fontSize:11,

                        },
                    },
                    axisLine: {
                        lineStyle: {
                            color: 'rgba(255,255,255,.1)'
                        }

                    },

                    data:infos

                }, {

                    axisPointer: {show: false},
                    axisLine: {  show: false},
                    position: 'bottom',
                    offset: 20,



                }],

                yAxis: [{
                    name: '比例',
                    nameTextStyle:{
                        color:'#fff'
                    },
                    type: 'value',
                    axisTick: {show: false},
                    // splitNumber: 6,
                    axisLine: {
                        lineStyle: {
                            color: 'rgba(255,255,255,.1)'
                        }
                    },
                    axisLabel:  {
                        formatter: "{value} %",
                        textStyle: {
                            color: "rgba(255,255,255,.6)",
                            fontSize:14,
                        },
                    },

                    splitLine: {
                        lineStyle: {
                            color: 'rgba(255,255,255,.1)'
                        }
                    }
                }],
                series: [
                    {
                        name: '上海',
                        type: 'line',
                        smooth: true,
                        symbol: 'circle',
                        symbolSize: 5,
                        showSymbol: false,
                        lineStyle: {
                            normal: {
                                color: 'rgba(228, 228, 126, 1)',
                                width: 2
                            }
                        },
                        areaStyle: {
                            normal: {
                                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                    offset: 0,
                                    color: 'rgba(228, 228, 126, .2)'
                                }, {
                                    offset: 1,
                                    color: 'rgba(228, 228, 126, 0)'
                                }], false),
                                shadowColor: 'rgba(0, 0, 0, 0.1)',
                            }
                        },
                        itemStyle: {
                            normal: {
                                color: 'rgba(228, 228, 126, 1)',
                                borderColor: 'rgba(228, 228, 126, .1)',
                                borderWidth: 12
                            }
                        },
                        data: sh

                    }, {
                        name: '北京',
                        type: 'line',
                        smooth: true,
                        symbol: 'circle',
                        symbolSize: 5,
                        showSymbol: false,
                        lineStyle: {

                            normal: {
                                color: 'rgba(255, 128, 128, 1)',
                                width: 2
                            }
                        },
                        areaStyle: {
                            normal: {
                                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                    offset: 0,
                                    color: 'rgba(255, 128, 128,.2)'
                                }, {
                                    offset:1,
                                    color: 'rgba(255, 128, 128, 0)'
                                }], false),
                                shadowColor: 'rgba(0, 0, 0, 0.1)',
                            }
                        },
                        itemStyle: {
                            normal: {
                                color: 'rgba(255, 128, 128, 1)',
                                borderColor: 'rgba(255, 128, 128, .1)',
                                borderWidth: 12
                            }
                        },
                        data: bj
                    }, {
                        name: '广州',
                        type: 'line',
                        smooth: true,
                        symbol: 'circle',
                        symbolSize: 5,
                        showSymbol: false,
                        lineStyle: {

                            normal: {
                                color: 'rgba(248,248,255,1)',
                                width: 2
                            }
                        },
                        areaStyle: {
                            normal: {
                                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                    offset: 0,
                                    color: 'rgba(248,248,255,.2)'
                                }, {
                                    offset:1,
                                    color: 'rgba(248,248,255, 0)'
                                }], false),
                                shadowColor: 'rgba(0, 0, 0, 0.1)',
                            }
                        },
                        itemStyle: {
                            normal: {
                                color: 'rgba(248,248,255, 1)',
                                borderColor: 'rgba(248,248,255, .1)',
                                borderWidth: 12
                            }
                        },
                        data: gz
                    },  {
                        name: '深圳',
                        type: 'line',
                        smooth: true,
                        symbol: 'circle',
                        symbolSize: 5,
                        showSymbol: false,
                        lineStyle: {

                            normal: {
                                color: 'rgba(255,0,0,1)',
                                width: 2
                            }
                        },
                        areaStyle: {
                            normal: {
                                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                    offset: 0,
                                    color: 'rgba(	255,0,0,.2)'
                                }, {
                                    offset:1,
                                    color: 'rgba(	255,0,0, 0)'
                                }], false),
                                shadowColor: 'rgba(0, 0, 0, 0.1)',
                            }
                        },
                        itemStyle: {
                            normal: {
                                color: 'rgba(	255,0,0, 1)',
                                borderColor: 'rgba(	255,0,0, .1)',
                                borderWidth: 12
                            }
                        },
                        data: sz
                    }
                ]
            };
            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
            window.addEventListener("resize",function(){
                myChart.resize();
            });
        });
}
    function echarts_3() {
        $.get("http://localhost:8080/house/housePC",function (data){
            var city = data.citys;
            var pc = data.peocount;
            var houseCount = data.housec;
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('echarts3'));

            option = {

                tooltip: {
                    trigger: 'axis',
                    axisPointer: { // 坐标轴指示器，坐标轴触发有效
                        type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                legend: {
                    data: ['二手房数量', '关注人数'],
                    right: 'center',
                    top:0,
                    textStyle: {
                        color: "#fff"
                    },
                    itemWidth: 12,
                    itemHeight: 10,
                    // itemGap: 35
                },
                grid: {
                    left: '0',
                    right: '20',
                    bottom: '0',
                    top:'15%',
                    containLabel: true
                },
                xAxis: {
                    type: 'category',
                    data: city,
                    axisLine: {
                        lineStyle: {
                            color: 'white'

                        }
                    },
                    axisLabel: {
                        //rotate:-90,
                        formatter:function(value){return value.split("").join("\n");},
                        textStyle: {
                            color: "rgba(255,255,255,.6)",
                            fontSize:14,
                        }
                    },
                    axisLine: {
                        lineStyle: {
                            color: 'rgba(255,255,255,0.3)'
                        }
                    },
                },

                yAxis: {
                    type: 'value',
                    splitNumber: 4,
                    axisTick: {show: false},
                    splitLine: {
                        show: true,
                        lineStyle: {
                            color: 'rgba(255,255,255,0.1)'
                        }
                    },
                    axisLabel: {textStyle: {
                            color: "rgba(255,255,255,.6)",
                            fontSize:14,
                        }},
                    axisLine: {show:false},
                },

                series: [{
                    name: '二手房数量',
                    type: 'bar',
                    stack: 'a',
                    barWidth: '30',barGap: 0,
                    itemStyle: {
                        normal: {
                            color: '#8bd46e', }
                    },
                    data: houseCount
                },

                    {
                        name: '关注人数',
                        type: 'bar',
                        stack: 'a',
                        barWidth: '30',barGap: 0,
                        itemStyle: {
                            normal: {
                                color: '#248ff7',
                                barBorderRadius:0, }
                        },
                        data: pc
                    }
                ]
            };

            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
            window.addEventListener("resize",function(){
                myChart.resize();
            });
        });

    }
    function echarts_5() {
        $.get("http://localhost:8080/house/area",function (data){
            var scope = data.scope;
            var city = data.citys;
            var numsh = data.sh;
            var numsz = data.sz;
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('echarts5'));

            option = {
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {type: 'shadow'},
                },"grid": {
                    "top": "15%",
                    "right":"10%",
                    "bottom":"20",
                    "left":"10%",
                },
                legend: {
                    data: city,
                    right: 'center',
                    top:0,
                    textStyle: {
                        color: "#fff"
                    },
                    itemWidth: 12,
                    itemHeight: 10,
                },
                "xAxis": [
                    {
                        "type": "category",

                        data: scope,
                        axisLine: { lineStyle: {color: "rgba(255,255,255,.1)"}},
                        axisLabel:  { textStyle: {color: "rgba(255,255,255,.7)", fontSize: '14', },
                        },

                    },
                ],
                "yAxis": [
                    {
                        "type": "value",
                        "name": "比例",
                        'nameTextStyle':{
                            color:'#fff'
                        },
                        splitLine: {show: false},
                        axisTick: {show: false},
                        "axisLabel": {
                            "show": true,
                            color: "rgba(255,255,255,.6)"

                        },
                        axisLine: {lineStyle: {color: 'rgba(255,255,255,.1)'}},//左线色

                    },
                    {
                        "type": "value",
                        "name": "比例",
                        nameTextStyle:{
                            color:'#fff'
                        },
                        "show": true,
                        axisTick: {show: false},
                        "axisLabel": {
                            "show": true,
                            // formatter: "{value} %",
                            color: "rgba(255,255,255,.6)"
                        },
                        axisLine: {lineStyle: {color: 'rgba(255,255,255,.1)'}},//右线色
                        splitLine: {show:true,lineStyle: {color:'rgba(255,255,255,.1)'}},//x轴线
                    },
                ],
                "series": [

                    {
                        "name": city[0],
                        "type": "bar",
                        "data": numsh,
                        "barWidth": "20%",

                        "itemStyle": {
                            "normal": {
                                barBorderRadius: 15,
                                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                    offset: 0,
                                    color: '#fccb05'
                                }, {
                                    offset: 1,
                                    color: '#f5804d'
                                }]),
                            }
                        },
                        "barGap": "0"
                    },
                    {
                        "name": city[1],
                        "type": "line",
                        "yAxisIndex": 1,

                        "data": numsz,
                        lineStyle: {
                            normal: {
                                width: 2
                            },
                        },
                        "itemStyle": {
                            "normal": {
                                "color": "#ff3300",

                            }
                        },
                        "smooth": true
                    }
                ]
            };
            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
            window.addEventListener("resize",function(){
                myChart.resize();
            });
        });

  }
    function echarts_4() {
     // 基于准备好的dom，初始化echarts实例

        $.get("http://localhost:8080/house/houseinfo",function (data){
            var ngz = data.gz;
            var nsh = data.sh;
            var nsz = data.sz;
            var nbj = data.bj;
            var citys = data.citys;
            var infos = data.infos;
            // alert(citys);
            var myChart = echarts.init(document.getElementById('echarts4'));
            var myColor=['#eb2100','#eb3600','#d0570e','#d0a00e','#34da62','#00e9db','#00c0e9','#0096f3'];
            option = {
                title: {
                    subtext: '此处不统计未知建造年份的二手房'
                },
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    top: '7%',
                    right: '5%',
                    textStyle: {
                        color:'rgba(255,255,255,.6)'
                    },
                    data: citys
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                toolbox: {
                    feature: {
                        saveAsImage: {}
                    }
                },
                xAxis: {
                    type: 'category',
                    name: '区间',
                    boundaryGap: false,
                    data: infos,
                    splitLine:{
                        show:false,
                        color:	'#FCFCFC'
                    },
                    axisLine: {
                        show:true,
                        lineStyle:{
                            color: 'rgba(255,255,255,.6)'
                        }
                    },
                    axisLabel: {
                        textStyle: {
                            color: 'rgba(255,255,255,.6)',
                            fontSize:'14',
                        }
                    }
                },
                yAxis: {
                    type: 'value',
                    name: '数量',
                    splitLine:{
                        show:true,
                        color:	'#FCFCFC'
                    },
                    axisLine:{
                        show:true,
                        lineStyle:{
                            color: 'rgba(255,255,255,.6)'
                        }
                    },
                    axisLabel: {
                        textStyle: {
                            color: 'rgba(255,255,255,.6)',
                            fontSize:'14',
                        }
                    }
                },
                grid: {
                    top: '20%'
                },
                series: [
                    {
                        name: '上海',
                        type: 'line',
                        stack: 'Total',
                        data: nsh
                    },
                    {
                        name: '北京',
                        type: 'line',
                        stack: 'Total',
                        data: nbj
                    },
                    {
                        name: '广州',
                        type: 'line',
                        stack: 'Total',
                        data: ngz
                    },
                    {
                        name: '深圳',
                        type: 'line',
                        stack: 'Total',
                        data: nsz
                    }
                ]
            };


            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
            window.addEventListener("resize",function(){
                myChart.resize();
            });
        });

  }
  function echarts_6() {
        $.get("http://localhost:8080/house/total",function (data){
           var sh = data.citys[0];
           var sz = data.citys[1];
           var gz = data.citys[2];
           var numsh = data.number[0];
           var numsz = data.number[1];
           var numgz = data.number[2];

            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('echarts6'));


            option = {
                title:{
                    // text:'5132',
                    subtext:'总体',
                    x:'center',
                    y:'40%',
                    textStyle:{
                        color:'#fff',
                        fontSize:22,
                        lineHeight:10,
                    },
                    subtextStyle: {
                        color:'#90979c',
                        fontSize:16,
                        lineHeight:10,

                    },
                },
                tooltip: {
                    trigger: 'item',
                    formatter: "{b} : {c} ({d}%)"
                },

                visualMap: {
                    show: false,
                    min: 500,
                    max: 600,
                    inRange: {
                        //colorLightness: [0, 1]
                    }
                },
                series: [{
                    name: '访问来源',
                    type: 'pie',
                    radius: ['50%', '70%'],
                    center: ['50%', '50%'],
                    color: ['rgb(131,249,103)', '#FBFE27', '#FE5050', '#1DB7E5'], //'#FBFE27','rgb(11,228,96)','#FE5050'
                    data: [{
                        "value": numsh,
                        "name": sh
                    }, {
                        "value": numgz,
                        "name": gz
                    }, {
                        "value": numsz,
                        "name": sz}
                    ].sort(function(a, b) {
                        return a.value - b.value
                    }),
                    roseType: 'radius',

                    label: {
                        normal: {
                            formatter: ['{c|{c}万}', '{b|{b}}'].join('\n'),
                            rich: {
                                c: {
                                    color: 'rgb(241,246,104)',
                                    fontSize: 20,
                                    fontWeight:'bold',
                                    lineHeight: 5
                                },
                                b: {
                                    color: 'rgb(98,137,169)',
                                    fontSize: 14,
                                    height: 44
                                },
                            },
                        }
                    },
                    labelLine: {
                        normal: {
                            lineStyle: {
                                color: 'rgb(98,137,169)',
                            },
                            smooth: 0.2,
                            length: 10,
                            length2: 20,

                        }
                    }
                }]
            };


            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
            window.addEventListener("resize",function(){
                myChart.resize();
            });
        });
}


    function pe01() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('pe01'));
        var txt=81
        option = {
            title: {
              text: txt+'%',
              x: 'center',
             y: 'center',
              textStyle: {
                fontWeight: 'normal',
                color: '#fff',
                fontSize: '18'
              }
            },
            color:'rgba(255,255,255,.3)',
         
            series: [{
              name: 'Line 1',
              type: 'pie',
              clockWise: true,
              radius: ['65%', '80%'],
              itemStyle: {
                normal: {
                  label: {
                    show: false
                  },
                  labelLine: {
                    show: false
                  }
                }
              },
              hoverAnimation: false,
              data: [{
                value: txt,
                name: '已使用',
                itemStyle: {
                  normal: {
                    color:'#eaff00',
                    label: {
                      show: false
                    },
                    labelLine: {
                      show: false
                    }
                  }
                }
              }, {
                name: '未使用',
                value: 100-txt
              }]
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        window.addEventListener("resize",function(){
            myChart.resize();
        });
    }

    function pe02() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('pe02'));
        var txt=17
        option = {
            title: {
              text: txt+'%',
              x: 'center',
             y: 'center',
              textStyle: {
                fontWeight: 'normal',
                color: '#fff',
                fontSize: '18'
              }
            },
            color:'rgba(255,255,255,.3)',
         
            series: [{
              name: 'Line 1',
              type: 'pie',
              clockWise: true,
              radius: ['65%', '80%'],
              itemStyle: {
                normal: {
                  label: {
                    show: false
                  },
                  labelLine: {
                    show: false
                  }
                }
              },
              hoverAnimation: false,
              data: [{
                value: txt,
                name: '已使用',
                itemStyle: {
                  normal: {
                    color:'#ea4d4d',
                    label: {
                      show: false
                    },
                    labelLine: {
                      show: false
                    }
                  }
                }
              }, {
                name: '未使用',
                value: 100-txt
              }]
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        window.addEventListener("resize",function(){
            myChart.resize();
        });
    }
    function pe03() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('pe03'));
        var txt=2
        option = {
            title: {
              text: txt+'%',
              x: 'center',
             y: 'center',
              textStyle: {
                fontWeight: 'normal',
                color: '#fff',
                fontSize: '18'
              }
            },
            color:'rgba(255,255,255,.3)',
         
            series: [{
              name: 'Line 1',
              type: 'pie',
              clockWise: true,
              radius: ['65%', '80%'],
              itemStyle: {
                normal: {
                  label: {
                    show: false
                  },
                  labelLine: {
                    show: false
                  }
                }
              },
              hoverAnimation: false,
              data: [{
                value: txt,
                name: '已使用',
                itemStyle: {
                  normal: {
                    color:'#395ee6',
                    label: {
                      show: false
                    },
                    labelLine: {
                      show: false
                    }
                  }
                }
              }, {
                name: '未使用',
                value: 100-txt
              }
            ]
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        window.addEventListener("resize",function(){
            myChart.resize();
        });
    }
})



		
		
		


		




















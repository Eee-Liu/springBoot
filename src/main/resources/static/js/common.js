// var option = {
//     url: '${springMacroRequestContext.contextPath}/operation/updateBusInfo.do',
//     type: 'POST',
//     data: {
//         "phone": $('#phone').val(),
//         "toCusPlus": $('#toCusPlus').val(),
//         "ecardNo": $('#ecardNo').val()
//     },
//     dataType: 'json',
// prePath:'${springMacroRequestContext.contextPath}',
//     success: function (data) {
//         //针对操作
//     }
// };
<!--统一处理发送ajax-->
function proxyAjax(option) {
    var preHandle = function (data) {
        if (data.code === 0) {
            option.success(data);
        } else if (data.code === -4 || data.code === -5) {
            ClearCookie();
            alert("您登录过期啦，不要乱动哦，请打开新页面登录后再回来操作吧 > 。<");
            // top.location.href = option.prePath + '/login.vo';
        }else {
            alert(data.message);
        }
    };
    $.ajax({
        contentType : "application/json",
        url: option.url,
        dataType: option.dataType,
        type: option.type,
        data: option.data,
        traditional :true,//可传递数组
        success: preHandle,
        error: function (data) {
            alert("请求失败");
        }
    });
}

function ClearCookie() {
    var expires = new Date();
    expires.setTime(expires.getTime() - 1000 * 60 * 60);
    //expires是对应过期时间的设置,不设这个值,cookie默认在关闭浏览器时失效
    document.cookie = "TOKEN=' ';path=/;expires=" + expires.toGMTString();
}

<!--弹窗-->
function alertDialog(title, url, method) {
    var content = '<iframe scrolling="auto" frameborder="0" src="' + url
        + '" style="width:100%;height:100%;"></iframe>';
    $('#dialog').dialog({
        title: title,
        content: content,
        buttons: [{
            text: '关闭',
            handler: function () {
                $('#dialog').dialog('close');
            }
        }],
        onClose: function () {
            if ("updateLogisticPrice" === method) {
                alert("ok");
                datagrid.datagrid('reload');
            }
        }
    });
    $('#dialog').dialog('open').dialog('center');
}

function buildMenus(menus) {
    var div = $("#menuDiv");
    var ul = $('<ul id="menu-list"></ul>');
    div.append(ul);
    for (var i = 0; i < menus.length; i++) {
        var menu = menus[i];
        if (menu.level == 1) {
            var l2Li = $('<li data-key="' + menu.id + '" data-parent-key="' + menu.superId + '"' + '"><a href="#">' + menu.title + '</a></li>');
            var l2Ul = $('<ul class="submenu"></ul>');
            for (var j = 0; j < menus.length; j++) {
                var l3Menu = menus[j];
                if (l3Menu.level == 2 && l3Menu.superId == menu.id) {
                    var str = '<li data-key="' + l3Menu.id + '" data-parent-key="' + l3Menu.superId + '"' + '"><a href="'+ l3Menu.url + '">' + l3Menu.title + '</a></li>';
                    var l3Menu = $(str);
                    l3Menu.appendTo(l2Ul);
                }
            }
            l2Ul.appendTo(l2Li);
            l2Li.appendTo(ul);
        }
    }
    div.addClass("jquery-accordion-menu");
    div.addClass("red");
    ul.appendTo(div);
    div.jqueryAccordionMenu();
    $(".submenu-indicator").each(function (i, e) {
        $(e).html("");
    });
    setMenuState(window.location.href);
}

function setMenuState(curUrl) {
    var actDom;
    $("#menu-list a").each(function (i, e) {
        var url = $(e).attr('href');
        if (curUrl == url) {
            actDom = e;
            return;
        }
    });
    var pid = $(actDom).parent().data('parent-key');
    $("#menu-list li").each(function (i, e) {
        if ($(e).data('key') == pid) {
            $(e).addClass("active");
            $(e).find('.submenu').css("display", "block");
            return;
        }
    });
    $(actDom).css({ "background-color": "#1F2F3C", color: "#fff" });
}

function showMemberTitle(userInfo) {
    if (userInfo) {
        $("#login_name").text(userInfo.nickName);
        $("#login_badge").text(userInfo.account);
    }
}

function hackSelect() {
    function createSelectMask(ops) {
        if ($("#" + ops.id + "SelectMask").length == 0) {
            var style = "position:absolute;top:0px;z-index:100;width:" + ops.width + ";height:" + ops.height + ";";
            var dom = "<div id='" + ops.id + "SelectMask' class='selectMask' style='" + style + "'></div>";
            $("#" + ops.id).parent().css("position", "relative");
            $("#" + ops.id).parent().append(dom);
            $("#" + ops.id + "SelectMask").bind("click", function (e) {
                $(this).prev().attr("multiple", "multiple").css("border", "1px solid #e1e1e1");
                $(this).prev().prev().removeClass("arrow-down").addClass("arrow-up");
                $(this).remove();
            })
        }
    }

    $("select").each(function (i, e) {
        createSelectMask({
            id: $(e).attr("id"),
            width: $(e).css("width"),
            height: $(e).css("height")
        });
    });

    $(".conWrap").delegate("option", "click", function (e) {
        var dom = $(e.target);
        var selectDom = dom.parent();
        if (selectDom.hasClass("no-border")) {
            selectDom.css("border", "0px");
        }
        selectDom.removeAttr("multiple");
        createSelectMask({
            id: selectDom.attr("id"),
            width: selectDom.css("width"),
            height: selectDom.css("height")
        });
        selectDom.prev().removeClass("arrow-up").addClass("arrow-down");
    });

    $("body").bind("click", function (eq) {
        if (!$(eq.target).attr("class") || !$(eq.target).attr("class").match("Mask")) {
            $("select").each(function (i, e) {
                var selectDom = $(e);
                if (selectDom.hasClass("no-border")) {
                    selectDom.css("border", "0px");
                }
                selectDom.removeAttr("multiple");
                createSelectMask({
                    id: selectDom.attr("id"),
                    width: selectDom.css("width"),
                    height: selectDom.css("height")
                })
                selectDom.prev().removeClass("arrow-up").addClass("arrow-down");
            });
        }
    });
}

var Mask = {
    init: function () {
        this.createMask();
        this.bindEvent();
    },
    createMask: function () {
        if ($("#mask").length == 0) {
            var dom = '<div id="mask" class="mask"></div>';
            $('body').append(dom);
        }
    },
    bindEvent: function () {
        $(document).bind("mask_open", function () {
            $("#mask").show();
        });

        $(document).bind("mask_close", function () {
            $("#mask").hide();
        });
    }
}

function confirmBox(ops) {
    this.ops = ops;
    this.init();
}

confirmBox.prototype = {
    init: function () {
        this.createBox();
        this.bindEvent();
    },
    createBox: function () {
        var that = this;
        Mask.init();
        $(this.ops.types).each(function (i, type) {
            switch (type) {
                case "remove":
                    that.createRemoveConfirm();
                    break;
                case "submit":
                    that.createSuccessConfirm();
                    break;
                default:
                    that.createRemoveConfirm();
                    that.createSuccessConfirm();
            }
        });
    },
    createRemoveConfirm: function () {
        if ($("#removeConfirm").length == 0) {
            var dom = '<div id="removeConfirm" class="confirm_box"><div class="text">确认移除?</div><div class="btns"><a href="javascript:;" class="confirm btn btn-warning btn-lg">确认</a><a href="javascript:;" class="cancel btn btn-default btn-lg">取消</a></div></div>';
            $('body').append(dom);
        }
        $("#removeConfirm").show();
        $(document).trigger("mask_open");
    },
    createSuccessConfirm: function () {
        if ($("#successConfirm").length == 0) {
            var dom = '<div id="successConfirm" class="confirm_box"><img class="success" src="/img/ops_success.jpg" /><div class="success_text">' + this.ops.content + '</div></div>';
        }
        $('body').append(dom);
        $(document).trigger("mask_open");
        this.ops.fucs.successFuc.call();
    },
    bindEvent: function () {
        $(document).bind("successConfirm_close", function () {
            $(document).trigger("mask_close");
            $("#successConfirm").hide();
        });

        $(document).bind("removeConfirm_open", function () {
            $(document).trigger("mask_open");
            $("#removeConfirm").show();
        });

        $(document).bind("removeConfirm_close", function () {
            $(document).trigger("mask_close");
            $("#removeConfirm").hide();
        });


        $("#removeConfirm .cancel").bind("click", function (e) {
            $("#removeConfirm").hide();
            $(document).trigger("mask_close");
        });
    }
}

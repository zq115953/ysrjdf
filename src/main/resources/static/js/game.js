$("#start").one('click',function () {
    var game = document.getElementById("game");
    var birdEle = document.getElementById("bird");
    var gameover = false;
    var g = 1;  //重力加速度

    var sky = {
        position: 0
    }

    var bird = {
        entity: birdEle,
        speedX: 5,
        speedY: 5,
        x: birdEle.offsetLeft,
        y: birdEle.offsetTop
    }

    function Pipe(position) {
        this.x = position;  //管道div的left属性值
        this.width = 52;
        this.upPipeY = 0;   //上管道div的top属性值
        this.upPipeH = parseInt(Math.random() * 175) + 100;  //上面管道div的高度
        this.downPipeY = this.upPipeH + 200;   //下管道div的top属性值
        this.downPipeH = 600 - this.downPipeY;  //下面管道div的高度。 600是div.game的高度

        var divUp = document.createElement("div");

        divUp.className = "pipeU";
        divUp.style.left = this.x + "px";
        divUp.style.top = this.upPipeY + "px";
        divUp.style.width = this.width + "px";
        divUp.style.height = this.upPipeH + "px";
        var divDown = document.createElement("div");
        divDown.className = "pipeD";
        divDown.style.left = this.x + "px";
        divDown.style.top = this.downPipeY + "px";
        divDown.style.width = this.width + "px";
        divDown.style.height = this.downPipeH + "px";

        game.appendChild(divUp);
        game.appendChild(divDown);

        var _this = this;
        setInterval(function () {
            _this.x -= 1;
            if (_this.x < -52) {
                _this.x = 800;
            }
            if (!gameover) {
                divUp.style.left = _this.x + "px";
                divDown.style.left = _this.x + "px";
            }
            var clsUp = (bird.x + 34 > _this.x) && (bird.x < _this.x + 52) && (bird.y < _this.upPipeH);
            var clsDown = (bird.x + 34 > _this.x) && (bird.x < _this.x + 52) && (bird.y + 26 > _this.downPipeY);
            if (clsUp || clsDown) {
                gameover = true;
            }
        }, 10)
    }


    setInterval(function () {
        if (!gameover) {
            bird.speedY = bird.speedY + g;
            bird.y = bird.y + bird.speedY;
            if (bird.y > 574) {
                bird.y = 574;
                gameover = true;
            }
            if (bird.y < 0) {
                bird.y = 0;
                gameover = true;
            }
            bird.entity.style.top = bird.y + "px";
            sky.position -= bird.speedX;
            game.style.backgroundPositionX = sky.position + "px";
        }
    }, 25)

    document.onmousedown = function () {
        bird.speedY = -10;
    }

    for (var i = 0; i < 4; i++) {
        new Pipe(400 + 800 / 4 * i);
    };
})

$("#restart").click(function(){
    setInterval(function () {
        $("#autore").load(location.href + " #autore");//注意后面DIV的ID前面的空格，很重要！没有空格的话，会出双眼皮！（也可以使用类名）
    },1000);//8秒自动刷新
})


$("#first").click(function () {
    $("#games").attr("style","display:block;");
})
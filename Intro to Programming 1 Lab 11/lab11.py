TITLE = 'COSC 1436 FPS'
BLOCK_SIZE = 87
WORLD_SIZE = 8
WIDTH = WORLD_SIZE*BLOCK_SIZE
HEIGHT = WORLD_SIZE*BLOCK_SIZE
fps = Actor('crosshair.png')
fps.x = 4*BLOCK_SIZE
fps.y = 4*BLOCK_SIZE
fps.score = 0
fps.dx = 0
fps.dy = 0
fps.fired = False

targets = []
for i in range(9):
    target = Actor('bullseye.png')
    target.x = i*BLOCK_SIZE
    target.y = 2*BLOCK_SIZE
    target.value = 10
    target.visible = True
    targets.append(target)

def draw():
    screen.clear()
    for t in targets:
        if t.visible:
            t.draw()
    fps.draw()
    screen.draw.text("Score: " + str(fps.score), topleft=(8, 4), fontsize=40)

def on_mouse_down(pos, button):
    fps.pos = pos
    fps.fired = True

def update():
    if fps.fired:
        fps.fired = False
        fps.image = 'explosion.png'
        for i in range(9):
            if fps.colliderect(targets[i]) and targets[i].visible:
                targets[i].visible = False
                fps.score += targets[i].value
        clock.schedule(resetImage, 0.2)

def resetImage():
    fps.image = 'crosshair.png'
HUD Z:37
```
		public void usePixelSystem(boolean b) {
				this.usePixelSystem = b;
			}
```
Warum gibt es kein getPixelSystem? Man kann nicht prüfen, welchen Wert die Variable hat  
Könnte man nicht stattdessen:
```
		public void draw(boolean usePixelSystem) {
				if (!usePixelSystem) {
					hudCamera.update();
					hudBatch.setProjectionMatrix(hudCamera.combined);
				}
				drawElements();
				resize();

			}
```
machen? Damit hat der Tester Kontrolle über die Variable

Außerdem sollte der Konstruktor keine Objekte mit new anlegen. Das verhindert das Mocken der Objekte, die sich beim Funktionsaufruf verändern
```
		public HUD() {
				hudBatch = new SpriteBatch();
				hudCamera = new OrthographicCamera();
				hudCamera.position.set(0, 0, 0);
				hudCamera.update();
				hudElements = new ArrayList<>();
			}
```
```			
		public HUD(SpriteBatch batches, OrthographicCamera camera) {
				hudBatch = batches;
				hudCamera = camera;
				hudCamera.position.set(0, 0, 0);
				hudCamera.update();
				hudElements = new ArrayList<>();
			}
```

Point Konstruktoren (Coordinate und Point and Input)
`IllegalArgumentExeption` für Parameter die `null` sind
float Variablen können nicht `null` sein. Daher hier nicht nötig
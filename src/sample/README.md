1) реализован класс бд
2) считывание из файла
3) отредактировал клас плоскости для 3Д(без дублирования массивов пикселей для поиска)
4) пиксели записываются только в установленных деталях с углом наклона, в остальных присваивается размер и значения 0
5) добавить счетчик деталей после которых не записаны пиксели 
6) 1 массив ploskosti. 
1 массив бд
в ploskosti сохраняютс сразу все детали с заданными координатами и углом наклона записываются пиксели, 
    сохраняется местоположение последней детали в массиве(с пикселями),
    записываются детали с координатами но без заданного угла.
после чего записываются детали которые устанавливаются рядом с деталью
после чего оставшиеся
7) метод добавления деталей в ploskosti с заданными кооринатами и углом(с проверкой)
записали деталь, получили координаты 8 точек, получили пиксели, провели проверку по уже установленным деталям.
8) реализован у 1,6,3 плоскости


1) метод установки с углом наклона(пиксели записываются)
2) метод установки без угла наклона
3) метод установки рядом
4) метод установки остальных
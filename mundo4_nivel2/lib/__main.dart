import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Layouts com Widgets',
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Layouts no Flutter'),
          backgroundColor: Colors.blueAccent,
        ),
        body: const LayoutExample(),
      ),
    );
  }
}

class LayoutExample extends StatelessWidget {
  const LayoutExample({super.key});

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceEvenly, // Distribui os elementos igualmente
        children: const [
          // 1ª Coluna
          Column(
            mainAxisSize: MainAxisSize.min, // Minimiza o espaço ocupado
            children: <Widget>[
              Icon(Icons.call, size: 50, color: Colors.blue), // Ícone
              Text('Call', style: TextStyle(fontSize: 18)), // Texto
            ],
          ),

          // 2ª Coluna
          Column(
            mainAxisSize: MainAxisSize.min,
            children: <Widget>[
              Icon(Icons.directions, size: 50, color: Colors.green),
              Text('Route', style: TextStyle(fontSize: 18)),
            ],
          ),

          // 3ª Coluna
          Column(
            mainAxisSize: MainAxisSize.min,
            children: <Widget>[
              Icon(Icons.share, size: 50, color: Colors.red),
              Text('Share', style: TextStyle(fontSize: 18)),
            ],
          ),
        ],
      ),
    );
  }
}

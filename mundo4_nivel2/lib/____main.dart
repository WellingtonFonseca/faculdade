import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Stack no Flutter',
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Exemplo de Stack'),
          backgroundColor: Colors.blueAccent,
        ),
        body: const StackExample(),
      ),
    );
  }
}

class StackExample extends StatelessWidget {
  const StackExample({super.key});

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Stack(
        alignment: Alignment.center, // Alinha os widgets no centro
        children: [
          // Container Azul
          Container(
            width: 250,
            height: 250,
            color: Colors.blue,
          ),
          // Container Vermelho
          Container(
            width: 200,
            height: 200,
            color: Colors.red,
          ),
          // Container Amarelo
          Container(
            width: 150,
            height: 150,
            color: Colors.yellow,
          ),
          // Texto Sobreposto
          const Positioned(
            top: 20, // Define a posição do texto
            child: Text(
              'Flutter Stack',
              style: TextStyle(
                fontSize: 20,
                fontWeight: FontWeight.bold,
                color: Colors.black,
              ),
            ),
          ),
        ],
      ),
    );
  }
}

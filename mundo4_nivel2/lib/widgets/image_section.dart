import 'package:flutter/material.dart';

// Seção de Imagem
class ImageSection extends StatelessWidget {
  const ImageSection({super.key});

  @override
  Widget build(BuildContext context) {
    return Image.asset(
      'assets/images/lake.jpg', // Caminho da imagem
      width: double.infinity, // Largura total
      height: 240, // Altura fixa
      fit: BoxFit.cover, // Ajuste para cobrir a área
    );
  }
}

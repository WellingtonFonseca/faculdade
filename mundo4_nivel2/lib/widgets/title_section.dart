import 'package:flutter/material.dart';

class TitleSection extends StatelessWidget {
  const TitleSection({super.key});

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(16),
      child: Row(
        children: [
          // Coluna expandida para o texto
          Expanded(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  'Maldivas - Resort Exclusivo',
                  style: const TextStyle(
                    fontSize: 20,
                    fontWeight: FontWeight.bold,
                  ),
                ),
                const SizedBox(height: 8),
                Text(
                  'Ilhas Maldivas, Oceano Índico',
                  style: TextStyle(
                    fontSize: 16,
                    color: Colors.grey[500],
                  ),
                ),
              ],
            ),
          ),
          // Ícone de estrela
          const Icon(
            Icons.star,
            color: Colors.orange,
          ),
          const SizedBox(width: 4),
          // Número de avaliações
          const Text('4.8'),
        ],
      ),
    );
  }
}

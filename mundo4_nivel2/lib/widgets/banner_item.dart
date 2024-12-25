import 'package:flutter/material.dart';

class BannerItem extends StatelessWidget {
  final String image;
  final String title;

  const BannerItem({super.key, required this.image, required this.title});

  @override
  Widget build(BuildContext context) {
    return Stack(
      fit: StackFit.expand,
      children: [
        Image.network(
          image,
          fit: BoxFit.cover,
          loadingBuilder: (context, child, loadingProgress) {
            if (loadingProgress == null) return child;
            return const Center(child: CircularProgressIndicator());
          },
          errorBuilder: (context, error, stackTrace) =>
              const Icon(Icons.error, size: 50, color: Colors.red),
        ),
        Container(color: Colors.black.withOpacity(0.5)),
        Positioned(
          bottom: 10,
          left: 10,
          child: Text(
            title,
            style: const TextStyle(
              color: Colors.white,
              fontSize: 24,
              fontWeight: FontWeight.bold,
            ),
          ),
        ),
      ],
    );
  }
}
